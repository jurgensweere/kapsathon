<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="col-12 mt-4">
      <!-- Receiver -->
      <b-form-group id="fieldset-horizontal" label-cols="2" label="To" label-for="input-horizontal">
        <b-form-input
          v-model="form.receiver"
          placeholder="frankie@goes.to"
          required
        ></b-form-input>
      </b-form-group>
      <!-- Receiver -->
      <b-form-group
        label-cols="2"
        label="Subject"
        label-for="input-horizontal"
      >
        <b-form-input
          v-model="form.subject"
          placeholder="Subject"
          required
        ></b-form-input>
      </b-form-group>

      <!-- Body -->
      <b-form-textarea v-model="form.body" rows="8"></b-form-textarea>
      <div class="my-4">
        <b-button type="submit" class="w-50 col-3 float-right" variant="success">Send</b-button>
        <b-button type="reset" class="w-50 col-3 mx-2 float-right" variant="secondary">Cancel</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
import { BASE_URL } from '../constants';

function emptyForm() {
  return {
        receiver: "",
        subject: "",
        body: "",
      };
}

export default {
  name: "Compose",
  data() {
    return {
      form: emptyForm(),
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      const body = {
        ...this.form,
        sender: "nigerian_prince@nl.rabobank.com",
        date: "2018-06-19 10:34:09",
      }
      fetch(`${BASE_URL}/sendemail`, {
        method: 'POST',
        // mode: 'no-cors',
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json',
        },

        body: JSON.stringify(body)
      })
          .then(stream => stream.json())
          .then(this.onSent)
          .catch(error => console.error(error));

    },
    onSent() {
      this.form = emptyForm();
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form = emptyForm();
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>