<template>
  <div id="app">
    <div class="row h-100">
      <div class="col-3 h-100 bg-dark py-2 px-0">
        <brand></brand>
        <left-side-bar/>
      </div>
      <div class="col-9 p-0 mt-111">
        <!-- below is part of some view -->
        <mailbox v-show="!compose"></mailbox>
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
html, body, #app {
  height: 100%;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.mt-111 {
  margin-top: 111px;
}

.border-radius-0 {
  border-radius: 0 !important;
}
</style>
