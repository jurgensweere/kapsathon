<template>
  <div>
    <b-button variant="success">New message</b-button>
<b-list-group v-for="item in elements" :key="item.id">
 <b-list-group-item href="#" variant="light">{{item.name}}</b-list-group-item>
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
      {name:'Starred', id:1},
      {name:'Archive', id:2},
      {name:'Trash', id:3},
      {name:'Spam', id:4},
      {name:'Sent', id:5},
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
