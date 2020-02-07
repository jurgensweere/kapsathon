<template>
  <b-list-group>
    <b-list-group-item href="#" class="flex-column align-items-start" :active="activeIndex == index" v-for="(email, index) in emails" :key="index" @click="openEmail(email, index)">
      <div class="d-flex w-100 justify-content-between">
        <h5 class="mb-1">{{ email.subject }}</h5>
        <small>{{ email.date }}</small>
      </div>
    </b-list-group-item>
  </b-list-group>
</template>

<script>
import { EventBus } from "../event-bus";

export default {
  name: "EmailList",
  components: {},
  data() {
      return {
          emails: [],
          activeIndex: -1
      }
  },
  methods: {
      openEmail(email, index) {
          this.activeIndex = index;
          EventBus.$emit('emailSelected', email)
      }
  },
  created() {
      EventBus.$on('open-mailbox', (emails) => {
          this.emails = emails;
      });
  }
};
</script>

<style>
</style>