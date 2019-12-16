package com.ht18.msys.admin.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ht18.msys.admin.security.OAuth2Filter;
import com.ht18.msys.admin.security.OAuth2Realm;
import com.ht18.msys.admin.security.MyShiroSessionListener;
import org.springframework.context.annotation.DependsOn;

/**
 * Shiro 配置
 * @author Louis
 * @date Sep 1, 2018
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        // 自定义 OAuth2Filter 过滤器，替代默认的过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", new OAuth2Filter());
        shiroFilter.setFilters(filters);
        // 访问路径拦截配置，"anon"表示无需验证，未登录也可访问
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/webjars/**", "anon");
        // 查看SQL监控（druid）
        filterMap.put("/druid/**", "anon");
        // 首页和登录页面
        filterMap.put("/", "anon");
        filterMap.put("/login", "anon");
        // swagger
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/webjars/springfox-swagger-ui/**", "anon");
       // filterMap.put("/sysUser/**", "anon");
        // 验证码
        filterMap.put("/captcha.jpg**", "anon");
        // 其他所有路径交给OAuth2Filter处理
        filterMap.put("/**", "oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean
    public Realm getShiroRealm(){
        OAuth2Realm myShiroRealm = new OAuth2Realm();
        myShiroRealm.setCachingEnabled(true);
        myShiroRealm.setAuthorizationCachingEnabled(true);
        return myShiroRealm;
    }

//    @Bean(name = "myRealm")
//    public org.apache.shiro.realm.AuthorizingRealm  getShiroRealm(){
//        AuthorizingRealm  realm = new OAuth2Realm();
//        realm.setName("my_shiro_auth_cache");
////        realm.setAuthenticationCache(getCacheManager().getCache(realm.getName()));
//        realm.setAuthenticationTokenClass(UsernamePasswordToken.class);
//        realm.setCredentialsMatcher(getHashedCredentialsMatcher());
//        return realm;
//    }
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        // 注入 Realm 实现类，实现自己的登录逻辑
//        OAuth2Realm myShiroRealm = new OAuth2Realm();
//        securityManager.setRealm(myShiroRealm);
//        return securityManager;
//    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setCacheManager(getCacheManager());
        //OAuth2Realm myShiroRealm = new OAuth2Realm();
        securityManager.setRealm(getShiroRealm());
        securityManager.setRememberMeManager(getRememberManager());
        securityManager.setSessionManager(getSessionManage());
        return securityManager;
    }



    @Bean(name = "sessionManager")
    public DefaultWebSessionManager getSessionManage(){

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);//过期时间30分钟
        //session定期验证
        sessionManager.setSessionValidationScheduler(getExecutorServiceSessionValidationScheduler());
        sessionManager.setDeleteInvalidSessions(true);
        //会话cookie
        sessionManager.setSessionIdCookie(getSessionIdCookie());
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //session监听
        LinkedList<SessionListener> list = new LinkedList<SessionListener>();
        list.add(new MyShiroSessionListener());
        sessionManager.setSessionListeners(list);
        //session的存储
        EnterpriseCacheSessionDAO cacheSessionDAO = new EnterpriseCacheSessionDAO();
        sessionManager.setCacheManager(getCacheManager());
        sessionManager.setSessionDAO(cacheSessionDAO);
        return sessionManager;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//缓存管理器
@Bean(name = "cacheShiroManager")
public EhCacheManager getCacheManager(){
    return new EhCacheManager();
}
    /**
     * Shiro生命周期处理器
     */
    //生命周期处理器
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    //浏览器会话的cookie管理
    @Bean(name = "sessionIdCookie")
    public SimpleCookie getSessionIdCookie(){
        SimpleCookie cookie = new SimpleCookie("sid");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);//浏览器关闭时失效此Cookie；
        return cookie;
    }

    //记住我的cookie管理
    @Bean(name = "rememberMeCookie")
    public SimpleCookie getRememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        cookie.setHttpOnly(true);
        cookie.setMaxAge(2592000);//记住我的cookie有效期30天
        return cookie;
    }

    //记住我cookie管理器
    @Bean
    public CookieRememberMeManager getRememberManager(){
        CookieRememberMeManager meManager = new CookieRememberMeManager();
        meManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        meManager.setCookie(getRememberMeCookie());
        return meManager;
    }

    //session验证管理器
    @Bean(name = "sessionValidationScheduler")
    public ExecutorServiceSessionValidationScheduler getExecutorServiceSessionValidationScheduler(){
        ExecutorServiceSessionValidationScheduler scheduler = new ExecutorServiceSessionValidationScheduler();
        //设置session验证时间,15分钟一次
        scheduler.setInterval(900000);
        return scheduler;
    }
    @Bean
    public MethodInvokingFactoryBean getMethodInvokingFactoryBean(){
        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        factoryBean.setArguments(new Object[]{getSecurityManager()});
        return factoryBean;
    }
    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }
}