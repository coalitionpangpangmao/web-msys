<template>
  <div class="login">
    <h1>{{ msg }}</h1>
    <h2>login page</h2>
   
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      msg: 'this is the login page'
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
