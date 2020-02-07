<template>
  <div>
    <div>{{email.body}}</div>
  </div>
</template>

<script>
import { EventBus } from "../event-bus";

export default {
  name: "EmailBody",
  components: {},
  props: ["emails"],
  data() {
    return {
        email: Object,
    };
  },
  created() {
      EventBus.$on('emailSelected', (email) => {
          this.email = email;
          console.log('email= ', this.email)
      })
  }
};
</script>
