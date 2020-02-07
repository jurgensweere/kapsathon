<template>
  <div id="app" class="container">
    <div class="row">
      <div class="col-3 h-100 bg-dark py-2">
        <brand></brand>
        <left-side-bar/>
      </div>
      <div class="col-9">
        <!-- below is part of some view -->
        <mailbox :emails="emails"></mailbox>
        <compose></compose>
        <!-- end -->
      </div>
    </div>
  </div>
</template>

<script>
import LeftSideBar from './components/LeftSideBar.vue'
import Mailbox from './components/Mailbox.vue'
import Compose from './components/Compose.vue'
import Brand from './components/Brand.vue'

export default {
  name: 'App',
  components: {
    LeftSideBar,
    Mailbox,
    Compose,
    Brand,
  },
  data() {
    return {
      emails: [
        {
          date: new Date(),
          subject: 'Nigerian Prince',
          sender: 'hax@stuff.ru',
          body: 'body1',
        }, {
          date: new Date(),
          subject: 'About that thing',
          sender: 'hr@nl.abnamro.com',
          body: 'body2',
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
