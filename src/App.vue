<template>
  <div id="app">
    <div class="row mh-100">
      <div class="col-md-3 col-12 mh-100 py-2 px-0 left-side-bar bg-gradient">
        <brand></brand>
        <left-side-bar/>
      </div>
      <div class="col-md-9 col-12 p-0">
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
  padding-left: 15px;
  padding-right: 15px;
}

.border-radius-0 {
  border-radius: 0 !important;
}

.box-shadow{
  box-shadow: -4px 0px 16px -9px rgba(0,0,0,0.62);
}

.list-group {
  text-align: left;
}

@media screen and (min-width: 768px) {
    .mh-100 {
        height: 100% !important;
    }
}

.btn:focus {
  box-shadow: none !important;
}

.bg-gradient {
  background-color: #920000 !important;
  /* background: rgb(52,58,64);
  background: linear-gradient(0deg, rgba(52,58,64,1) 54%, rgba(148,0,0,1) 100%); */
}
.list-group-item {
  color: #000 !important;
  background-color: #eee !important;
  border-color: #eee !important;
}
.list-group-item.active {
  color: #000 !important;
  background-color: #FFF !important;
  border-color: #FFF !important;
}
</style>
