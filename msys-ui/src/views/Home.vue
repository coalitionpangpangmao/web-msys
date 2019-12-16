<template>
  <div class="home">
    <h1>{{ msg }}</h1>
    <h2>home page</h2>
   
  </div>
</template>

<script>
export default {
  name: 'Home',
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
