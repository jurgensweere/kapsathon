<template>
  <b-list-group>
    <b-list-group-item
      href="#"
      class="flex-column align-items-start border-radius-0"
      :active="activeIndex == index"
      v-for="(email, index) in emails"
      :key="index"
      @click="openEmail(email, index)"
    >
      <div>
        <i>{{ email.sender }}</i>
      </div>
      <div class="d-flex w-100 justify-content-between">
        <h5 class="mb-1 text-truncate">{{ email.subject }}</h5>
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
      activeIndex: 0
    };
  },
  methods: {
    openEmail(email, index) {
      this.activeIndex = index;
      EventBus.$emit("emailSelected", email);
    }
  },
  created() {
    EventBus.$on("open-mailbox", emails => {
      this.emails = emails;
      if (this.emails.length > 0) {
        this.openEmail(this.emails[0], 0);
      } else {
        EventBus.$emit("emailSelected", {});
      }
    });
  }
};
</script>

<style>

</style>