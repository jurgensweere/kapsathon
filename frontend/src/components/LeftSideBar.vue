<template>
  <div>
    <div class="my-2">
      <b-button class="w-100 border-0" variant="success" @click="compose()">New message</b-button>
    </div>
    <b-list-group v-for="item in elements" :key="item.id">
      <b-list-group-item href="#" variant="light" @click="openMailbox(item)">
        {{item.name}}
        <b-badge class="float-right" variant="success">{{item.counter}}</b-badge>
        <b-icon class="float-left" :icon="item.icon" scale="1" variant="success"></b-icon>
      </b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>
import { EventBus } from "../event-bus";
export default {
  name: "LeftSideBar",
  data: () => {
    return {
      elements: [
      { name: "Inbox", id: 1, icon: "inbox-fill", counter: 3 },
      { name: "Archive", id: 2, icon: "archive-fill", counter: 3 },
      { name: "Sent", id: 3, icon: "eject-fill", counter: 3 },
      { name: "Spam", id: 4, icon: "cone", counter: 3 }
    ]
    };
  },
  methods: {
    compose() {
      EventBus.$emit("compose");
    },
    openMailbox(mailbox) {
      //TODO fetch data
      console.log(mailbox);
      EventBus.$emit("open-mailbox", {});
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
