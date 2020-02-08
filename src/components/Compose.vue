<template>
  <div class="mt-5">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="col-10">
      <!-- Receiver -->
      <b-form-group id="fieldset-horizontal" label-cols="1" label="To" label-for="input-horizontal">
        <b-form-input
          id="input-horizontal"
          v-model="form.receiver"
          placeholder="Enter email"
          required
        ></b-form-input>
      </b-form-group>
      <!-- Receiver -->
      <b-form-group
        id="fieldset-horizontal"
        label-cols="1"
        label="Message"
        label-for="input-horizontal"
      >
        <b-form-input
          id="input-horizontal"
          v-model="form.receiver"
          placeholder="Enter email"
          required
        ></b-form-input>
      </b-form-group>

      <!-- Body -->
      <b-form-textarea id="textarea" v-model="text" rows="8" class="mx-2"></b-form-textarea>
      <div class="my-4">
        <b-button type="submit" class="w-50 col-3 mx-2 float-right" variant="success">Send</b-button>
        <b-button type="reset" class="w-50 col-3 mx-2 float-right" variant="secondary">Cancel</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
export default {
  name: "Compose",
  data() {
    return {
      form: {
        email: "",
        name: "",
        food: null,
        checked: []
      },
      foods: [
        { text: "Select One", value: null },
        "Carrots",
        "Beans",
        "Tomatoes",
        "Corn"
      ],
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.email = "";
      this.form.name = "";
      this.form.food = null;
      this.form.checked = [];
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>