<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="col-12 mt-4">
      <!-- Receiver -->
      <b-form-group id="fieldset-horizontal" label-cols="2" label="To" label-for="input-horizontal">
        <b-form-input v-model="form.receiver" placeholder="frankie@goes.to" required></b-form-input>
      </b-form-group>
      <!-- Receiver -->
      <b-form-group label-cols="2" label="Subject" label-for="input-horizontal">
        <b-form-input v-model="form.subject" placeholder="Subject" required></b-form-input>
      </b-form-group>

      <!-- Body -->
      <div class="editor text-left">
        <editor-menu-bar :editor="editor" v-slot="{ commands, isActive, getMarkAttrs }">
          <div class="menubar">
            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.bold() }"
              @click="commands.bold"
            >
              <b-icon icon="type-bold" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.italic() }"
              @click="commands.italic"
            >
              <b-icon icon="type-italic" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.strike() }"
              @click="commands.strike"
            >
              <b-icon icon="type-strikethrough" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.underline() }"
              @click="commands.underline"
            >
              <b-icon icon="type-underline" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.paragraph() }"
              @click="commands.paragraph"
            >p</button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.heading({ level: 1 }) }"
              @click="commands.heading({ level: 1 })"
            >
              <b-icon icon="type-h1" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.heading({ level: 2 }) }"
              @click="commands.heading({ level: 2 })"
            >
              <b-icon icon="type-h2" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.heading({ level: 3 }) }"
              @click="commands.heading({ level: 3 })"
            >
              <b-icon icon="type-h3" />
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.bullet_list() }"
              @click="commands.bullet_list"
            >
              <b-icon icon="list-ul"></b-icon>
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.ordered_list() }"
              @click="commands.ordered_list"
            >
              <b-icon icon="list-ol"></b-icon>
            </button>

            <button
              type="button"
              class="menubar__button"
              :class="{ 'is-active': isActive.blockquote() }"
              @click="commands.blockquote"
            >
              <b-icon icon="blockquote-left"></b-icon>
            </button>

            <button
              type="button"
              class="menubar__button"
              @click="showLinkMenu(getMarkAttrs('link'))"
              :class="{ 'is-active': isActive.link() }"
            >
              <!-- <span>{{ isActive.link() ? 'Update Link' : 'Add Link'}}</span> -->
              <b-icon icon="code-slash" />
            </button>

            <button type="button" class="menubar__button" @click="commands.undo">
              <b-icon icon="arrow-counterclockwise" />
            </button>

            <button type="button" class="menubar__button" @click="commands.redo">
              <b-icon icon="arrow-clockwise" />
            </button>
            <div class="url-edit">
              <form
                class="menububble__form"
                v-if="linkMenuIsActive"
                @submit.prevent="setLinkUrl(commands.link, linkUrl)"
              >
                <input
                  class="menububble__input"
                  type="text"
                  v-model="linkUrl"
                  placeholder="https://"
                  ref="linkInput"
                  @keydown.esc="hideLinkMenu"
                />
                <button
                  class="menububble__button"
                  @click="setLinkUrl(commands.link, null)"
                  type="button"
                >
                  <b-icon icon="trash" />
                </button>
              </form>
            </div>
          </div>
        </editor-menu-bar>

        <editor-content class="editor__content form-control mt-2" :editor="editor" />
      </div>
      <div class="my-4">
        <b-button type="submit" class="w-50 col-3 float-right" variant="success">Send</b-button>
        <b-button type="reset" class="w-50 col-3 mx-2 float-right" variant="secondary">Cancel</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
import { Editor, EditorContent, EditorMenuBar } from "tiptap";
import {
  Blockquote,
  CodeBlock,
  HardBreak,
  Heading,
  OrderedList,
  BulletList,
  ListItem,
  TodoItem,
  TodoList,
  Bold,
  Code,
  Italic,
  Link,
  Strike,
  Underline,
  History
} from "tiptap-extensions";
import { BASE_URL } from "../constants";

function emptyForm() {
  return {
    receiver: "",
    subject: "",
    body: ""
  };
}

export default {
  name: "Compose",
  components: {
    EditorContent,
    EditorMenuBar
  },
  data() {
    return {
      form: emptyForm(),
      show: true,

      linkUrl: null,
      linkMenuIsActive: false,
      editor: new Editor({
        extensions: [
          new Blockquote(),
          new CodeBlock(),
          new HardBreak(),
          new Heading({ levels: [1, 2, 3] }),
          new BulletList(),
          new OrderedList(),
          new ListItem(),
          new TodoItem(),
          new TodoList(),
          new Bold(),
          new Code(),
          new Italic(),
          new Link(),
          new Strike(),
          new Underline(),
          new History()
        ],
        content: ``
      })
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      const body = {
        ...this.form,
        sender: "nigerian_prince@nl.rabobank.com"
      };
      fetch(`${BASE_URL}/sendemail`, {
        method: "POST",
        // mode: 'no-cors',
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json"
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
    },
    showLinkMenu(attrs) {
      this.linkUrl = attrs.href;
      this.linkMenuIsActive = true;
      this.$nextTick(() => {
        this.$refs.linkInput.focus();
      });
    },
    hideLinkMenu() {
      this.linkUrl = null;
      this.linkMenuIsActive = false;
    },
    setLinkUrl(command, url) {
      command({ href: url });
      this.hideLinkMenu();
    }
  },
  beforeDestroy() {
    this.editor.destroy();
  }
};
</script>

<style scoped>
.editor__content {
  height: 300px;
  overflow: scroll;
}
</style>