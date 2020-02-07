<template>
    <div class="row">
        <div class="col-4">
        <email-list :emails="emails"></email-list>
        </div>
        <div class="col-8">
        here is the body
        </div>
    </div>
</template>

<script>
import EmailList from './EmailList';

export default {
  name: "Mailbox",
  components: {
      EmailList
  },
  props: ['emails'],
  methods: {

  }
};
</script>

<style>
</style>