<template>
  <div class="home">
    <h1>{{ msg }}</h1>
   <el-button type="primary" @click="testaxios()">Axios测试</el-button>
   <el-button type="primary" @click="getUser()">用户</el-button>
   <el-button type="primary" @click="getMenu()">菜单</el-button>
   
  </div>
</template>

<script>
import axios from "axios"
import mock from "@/mock/mock.js"
export default {
  name: 'Home',
  methods:{
    testaxios(){
      axios.get('http://localhost:8080')
      .then(function(res){
        alert(res.data);
      }).catch(function(res){
        alert(res);
      })
    },
    getUser(){
       axios.get('http://localhost:8080/user')
      .then(function(res){
        alert(JSON.stringify(res.data));
      }).catch(function(res){
        alert(res);
      })
    },
    getMenu(){
       axios.get('http://localhost:8080/menu')
      .then(function(res){
        alert(JSON.stringify(res.data));
      }).catch(function(res){
        alert(res);
      })
    },
  },
  data () {
    return {
      msg: 'this is the home page'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

</style>
