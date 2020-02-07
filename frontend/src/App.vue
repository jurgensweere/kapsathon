<template>
  <div id="app">
    <left-side-bar/>
  </div>
</template>

<script>
import LeftSideBar from './components/LeftSideBar.vue'

export default {
  name: 'App',
  components: {
    LeftSideBar
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
