<template>
    <div class="row">
        <div class="col-4">
        <email-list :emails="emails"></email-list>
        </div>
        <div class="col-8">
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