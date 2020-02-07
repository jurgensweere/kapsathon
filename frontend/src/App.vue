<template>
  <div id="app">
    <div class="row">
      <div class="col-3 p-0">
        <brand></brand>
        <left-side-bar/>
      </div>
      <div class="col-9 p-0 mt-101">
        <!-- below is part of some view -->
        <mailbox :emails="emails" v-if="!compose"></mailbox>
        <compose v-if="compose"></compose>
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
import { EventBus } from './event-bus'

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
      compose: false,
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
  },
  created() {
    EventBus.$on('compose', () => {
      this.compose = true;
    });
    EventBus.$on('open-mailbox', () => {
      this.compose = false;
    });
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
}

.mt-101 {
  margin-top: 101px;
}

</style>
