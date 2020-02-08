<template>
  <div>
    <b-list-group class="email-folders">
      <div class="py-2">
        <b-button
          class="w-100 border-0 border-radius-0 d-flex justify-content-center text-center"
          variant="dark"
          @click="compose()"
        >
          <b-icon class icon="cursor" scale="1" variant="light" />
          <span>New message</span>
        </b-button>
      </div>
      <b-list-group-item href="#" variant="light" @click="openMailbox(item)" class="border-radius-0 d-flex" v-for="item in elements" :key="item.id">
        <div class="mr-1"><b-icon class="" :icon="item.icon" scale="1" variant="dark"></b-icon></div>
        <span class="d-none d-md-inline-block">{{item.name}}</span>
        <div class="ml-auto"><b-badge class="" variant="danger">{{item.counter}}</b-badge></div>
      </b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>
import { EventBus } from "../event-bus";
import { BASE_URL } from '../constants';
import  faker from 'faker';

export default {
  name: "LeftSideBar",
  data: () => {
    return {
      elements: [
        { name: "Inbox", id: 1, icon: "inbox-fill", counter: 3 },
        { name: "Sent", id: 2, icon: "eject-fill", counter: 3 },
        { name: "Archive", id: 3, icon: "archive-fill", counter: 3 },
        { name: "Spam", id: 4, icon: "cone", counter: 3 },
        { name: "Generate", id: 5, icon: "cone", counter: 3 }
      ]
    };
  },
  created() {
    this.openMailbox(this.elements[0]);
  },
  methods: {
    compose() {
      EventBus.$emit("compose");
    },
    openMailbox(mailbox) {
      console.log('openMailbox', mailbox);
      if(mailbox.name === 'Generate'){
        this.generate();
      } else {
        fetch(`${BASE_URL}/get_email/${mailbox.name.toLowerCase()}`)
            .then(stream => stream.json())
            .then(data => EventBus.$emit("open-mailbox", data))
            .catch(error => console.error(error));
        }
    },
    generate() {
      for(let i=0; i<1; i++) {

      let body = {
        sender: faker.internet.email(),
        receiver: faker.internet.exampleEmail(),
        subject: faker.hacker.phrase(),
        body: faker.hacker.phrase(),
      };
      
      console.log('openMailbox result', body);
        fetch(`${BASE_URL}/sendemail`, {
       method: "POST",
        // mode: 'no-cors',
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json"
        },

        body: JSON.stringify(body)
      })
      .then(r => console.log("exxx ", r))
      .catch(error => console.error('getting error', error));
      }
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

@media screen and (max-width: 768px) {
    .email-folders {
        flex-direction: row;
    }
}
</style>
