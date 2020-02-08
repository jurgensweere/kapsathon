<template>
    <div class="row m-0 h-100">
        <div class="col-md-4 col-12 p-0 h-100">
        <email-list :emails="emails"></email-list>
        </div>
        <div class="col-md-8 col-12 p-0 h-100 box-shadow">
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