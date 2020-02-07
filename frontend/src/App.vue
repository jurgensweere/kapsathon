<template>
  <div id="app" class="container">
    <div class="row">
      <div class="col-3">
        <left-side-bar/>
      </div>
      <div class="col-9">
        <!-- below is part of some view -->
        <div class="row">
          <div class="col-4">
            <email-list :emails="emails"></email-list>
          </div>
          <div class="col-8">
            here is the body
          </div>
        </div>
        <!-- end -->
      </div>
    </div>
  </div>
</template>

<script>
import LeftSideBar from './components/LeftSideBar.vue'
import EmailList from './components/EmailList.vue'

export default {
  name: 'App',
  components: {
    LeftSideBar,
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
