<template>
  <div class="text-left p-3" v-if="email.body">
    <p><span class="person">{{ email.sender }}</span> to <span class="person">{{ email.receiver }}</span></p>
    <div v-html="email.body"></div>
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
      })
  }
};
</script>
<style scoped>
.person {
  font-weight: bold;
}

</style>