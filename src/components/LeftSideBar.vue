<template>
  <div>
    <b-list-group class="email-folders">
      <div class="py-2">
        <b-button
          class="w-100 border-0 border-radius-0 border-0 d-flex justify-content-center text-center"
          variant="dark"
          @click="compose()"
        >
          <b-icon class icon="cursor" scale="1" variant="light" />
          <span>New message</span>
        </b-button>
      </div>
      <b-list-group-item href="#" variant="light" @click="openMailbox(item, index)" :class="{'active' : activeIndex == index}" class="border-radius-0 d-flex border-0" v-for="(item, index) in elements" :key="item.id">
        <div class="mr-1"><b-icon class="" :icon="item.icon" scale="1" variant="dark"></b-icon></div>
        <span class="d-none d-md-inline-block">{{item.name}}</span>
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
      activeIndex: 0,
      elements: [
        { name: "Inbox", id: 1, icon: "inbox-fill"},
        { name: "Sent", id: 2, icon: "eject-fill"},
        { name: "Archive", id: 3, icon: "archive-fill"},
        { name: "Spam", id: 4, icon: "cone"}
      ]
    };
  },
  created() {
    this.openMailbox(this.elements[0], 0);
  },
  methods: {
    compose() {
      EventBus.$emit("compose");
      this.activeIndex = -1;
    },
    openMailbox(mailbox, index) {
      this.activeIndex = index;
      fetch(`${BASE_URL}/get_email/${mailbox.name.toLowerCase()}`)
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
  color: #343a40;
}

.list-group-item:hover,
.list-group-item:active {
  background-color: #cccccc !important;
}

@media screen and (max-width: 768px) {
    .email-folders {
        flex-direction: row;
    }
}

.list-group-item-action.active {
  background-color: #cccccc !important;
}
</style>
