<template>
  <div id="app">
    <email-list :emails="emails"></email-list>
  </div>
</template>

<script>
import EmailList from './components/EmailList.vue'

export default {
  name: 'App',
  components: {
    EmailList
  },
  data() {
    return {
      emails: [
        {
          date: new Date(),
          subject: 'Nigerian Prince',
          sender: 'hax@stuff.ru',
        }, {
          date: new Date(),
          subject: 'About that thing',
          sender: 'hr@nl.abnamro.com',
        }
      ]
    }
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
