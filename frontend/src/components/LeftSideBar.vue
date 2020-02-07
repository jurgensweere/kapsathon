<template>
  <div>
    <b-button variant="success">New message</b-button>
<b-list-group v-for="item in elements" :key="item.id">
 <b-list-group-item href="#" variant="light">{{item.name}}
   <b-icon :icon="item.icon" scale="1" variant="danger"></b-icon>
 </b-list-group-item>
</b-list-group>
   
  </div>
</template>

<script>
export default {
  name: "LeftSideBar",
  props: {
    elements: Array
  },
  data:()=>{
    return{
      elements: {type: Array, default: []}
    }
  },
  created(){
    this.elements = [ 
      {name:'Inbox', id:1, icon: 'inbox-fill'},
      {name:'Archive', id:2, icon: 'archive-fill'},
      {name:'Sent', id:3 , icon: 'eject-fill'},
      {name:'Spam', id:4, icon: 'cone'} 
      ]
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
