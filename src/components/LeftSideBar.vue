<template>
  <div>
    <div class="my-2">
      <b-button class="w-100 border-0 border-radius-0" variant="success" @click="compose()">
        New message
        <b-icon class="float-left" icon="cursor" scale="1" variant="light" />
      </b-button>
    </div>
    <b-list-group class="email-folders">
      <b-list-group-item href="#" variant="light" @click="openMailbox(item)" class="border-radius-0" v-for="item in elements" :key="item.id">
        {{item.name}}
        <b-badge class="float-right" variant="success">{{item.counter}}</b-badge>
        <b-icon class="float-left" :icon="item.icon" scale="1" variant="success"></b-icon>
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
console.log(mailbox)
      fetch(`${BASE_URL}/get_emails`)
          .then(stream => stream.json())
          .then(data => EventBus.$emit("open-mailbox", data))
          .catch(error => console.error(error))
   
      //TODO fetch data
      // const emails = [
      //   {
      //     id: "1",
      //     sender: "nigerian_prince@hotmale.com",
      //     receiver: "jonnie85@gmail.com",
      //     subject: "Free money my friend",
      //     body: "Hi I offer you free money",
      //     date: "2018-06-19 10:34:09",
      //     meta: "meta meta meta meta META",
      //     metadata: "meta meta meta meta META"
      //   },
      //   {
      //     id: "1",
      //     sender: "kenyan_prince@hotmale.com",
      //     receiver: "jonnie85@gmail.com",
      //     subject: "Free money my friend",
      //     body: "Hi I do not offer you free money",
      //     date: "2018-06-19 10:34:09",
      //     meta: "meta meta meta meta META",
      //     metadata: "meta meta meta meta META"
      //   }
      // ];
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
