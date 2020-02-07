<template>
  <b-list-group>
    <b-list-group-item href="#" class="flex-column align-items-start" :active="email.active" v-for="(email, index) in emails" :key="index" @click="openEmail(email)">
      <div class="d-flex w-100 justify-content-between">
        <h5 class="mb-1">{{ email.subject }}</h5>
        <small>{{ email.date }}</small>
      </div>
    </b-list-group-item>
  </b-list-group>
</template>

<script>
export default {
  name: "EmailList",
  components: {},
  props: ['emails'],
  methods: {
      openEmail(email) {
          email.active = true;
          console.log(email);
      }
  }
};
</script>

<style>
</style>