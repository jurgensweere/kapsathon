<template>
    <div class="row m-0">
        <div class="col-4 p-0">
        <email-list :emails="emails"></email-list>
        </div>
        <div class="col-8 p-0">
        <email-body></email-body>
        </div>
    </div>
</template>

<script>
import EmailList from './EmailList';
import EmailBody from './EmailBody';

export default {
  name: "Mailbox",
  components: {
      EmailList,
      EmailBody
  },
  props: ['emails'],
  methods: {

  }
};
</script>

<style>
</style>