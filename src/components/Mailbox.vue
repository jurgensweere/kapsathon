<template>
    <div class="row m-0 h-100">
        <div class="mail-list col-lg-4 col-md-5 col-12 p-0 h-100">
        <email-list :emails="emails"></email-list>
        </div>
        <div class="col-lg-8 col-md-7 col-12 p-0 h-100 box-shadow">
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
.mail-list {
    background-color: #eee;
    overflow: scroll;
    height: 100%;
}
</style>