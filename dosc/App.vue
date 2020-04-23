<template>
  <div id="app">
    <el-row>
      <el-col :span="4">
        <div class="infinite-list-wrapper" style="overflow:auto">
          <ul
                  class="list"
                  v-infinite-scroll="load"
                  infinite-scroll-disabled="disabled">
            <li v-for="item in countData" class="list-item" :key="item.id" @click="get(item.name)">{{ item.id }}</li>
          </ul>
          <p v-if="loading">加载中...</p>
          <p v-if="noMore">没有更多了</p>
        </div>
      </el-col>
      <el-col :span="20"><div class="grid-content bg-purple-light">{{data}}</div></el-col>
    </el-row>

  </div>

</template>

<script>
  // import HelloWorld from './components/HelloWorld.vue'

  export default {
    name: 'App',
    components: {
      // HelloWorld
    },
    data () {
      return {
        countData: [],
        loading: false,
        data:'1'
      }
    },
    created(){
      for (let i = 0; i < 10; i++) {
        this.countData.push({
          id:i,
          name: '张按'+i
        })
      }
    },
    computed: {
      noMore () {
        return this.countData.length >= 20
      },
      disabled () {
        return this.loading || this.noMore
      }
    },
    methods: {
      load () {
        this.loading = true
        let i = Number(11)
        setTimeout(() => {
          this.countData .push({
            id:i,
            name: '张按'+i
          })
          i = i + 1
          this.loading = false
        }, 2000)
      },
      get(i){
        this.data = i
      }
    }
  }
</script>

<style>
  .infinite-list-wrapper{
  }
  .list{
    padding: 0px !important;
    margin: 0px !important;
  }
  .list-item {
    height: 70px;
    overflow-y: auto;
    background: peachpuff;
    padding: 0;
    margin-bottom: 10px;
  }
</style>
