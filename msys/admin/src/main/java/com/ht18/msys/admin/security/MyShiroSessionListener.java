package com.ht18.msys.admin.security;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MyShiroSessionListener implements SessionListener {

    private Logger log = Logger.getLogger(MyShiroSessionListener.class);
    @Override
    public void onStart(Session session) {
        log.info("----会话创建:"+session.getId());
    }

    @Override
    public void onStop(Session session) {
        log.info("----会话停止:"+session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        log.info("----会话过期:"+session.getId());
    }

}
