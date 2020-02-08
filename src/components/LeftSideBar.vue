<template>
  <div>
    <b-list-group class="email-folders">
      <b-list-group-item href="#" variant="light" @click="openMailbox(item)" class="border-radius-0 d-flex" v-for="item in elements" :key="item.id">
        <div class="mr-1"><b-icon class="" :icon="item.icon" scale="1" variant="success"></b-icon></div>
        <span class="d-none d-md-inline-block">{{item.name}}</span>
        <div class="ml-auto"><b-badge class="" variant="success">{{item.counter}}</b-badge></div>
      </b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>
import { EventBus } from "../event-bus";
import { BASE_URL } from '../constants';

export default {
  name: "LeftSideBar",
  data: () => {
    return {
      elements: [
        { name: "Inbox", id: 1, icon: "inbox-fill", counter: 3 },
        { name: "Sent", id: 2, icon: "eject-fill", counter: 3 },
        { name: "Archive", id: 3, icon: "archive-fill", counter: 3 },
        { name: "Spam", id: 4, icon: "cone", counter: 3 }
      ]
    };
  },
  methods: {
    compose() {
      EventBus.$emit("compose");
    },
    openMailbox(mailbox) {
      fetch(`${BASE_URL}/get_emails/${mailbox.name.toLowerCase()}`)
          .then(stream => stream.json())
          .then(data => EventBus.$emit("open-mailbox", data))
          .catch(error => console.error(error));
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

@media screen and (max-width: 768px) {
    .email-folders {
        flex-direction: row;
    }
}
</style>
