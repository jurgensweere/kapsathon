
<template>
  <div class="py-2 bg-dark">
    <b-button
      class="w-100 border-0 border-radius-0 d-flex justify-content-center text-center"
      variant="success"
      @click="compose()"
    >
      <b-icon class icon="cursor" scale="1" variant="light" />
      <span>New message</span>
    </b-button>
  </div>
</template>

<script>
export default {
  name: "NewMessageButton"
};
</script>