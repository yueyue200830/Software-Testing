<template>
  <div id="app">
    <el-container>
      <el-main>
        <div class="header">Timeline</div>
        <el-button icon="el-icon-refresh-right" circle class="refresh" @click="refresh"></el-button>
        <div class="main-card" v-for="comment in comments" :key="comment.id">
          <transition
                  appear
                  appear-class="box-card-appear-class"
                  appear-active-class="box-card-appear-active-class"
                  :duration="1000"
          >
            <el-card class="box-card" shadow="always">
              <div slot="header" class="headline">
                <div class="user">{{ comment.user }}</div>
                <div class="time">{{ convertTime(comment.time) }}</div>
              </div>
              <div class="card-content">
                <div class="text">
                  {{ comment.comment }}
                </div>
                <el-image class="image" fit="contain" v-if="comment.image != null"
                          :src="comment.image">
                </el-image>
              </div>
            </el-card>
          </transition>
        </div>
        <transition
                appear
                appear-class="box-card-appear-class"
                appear-active-class="box-card-appear-active-class"
                :duration="1000"
        >
          <div class="more">
            <el-button :loading="false" @click="loadMore" class="load-more">
              More
            </el-button>
          </div>
        </transition>
      </el-main>
      <el-footer>Software Testing - Project 2 by Jiayi Zhu</el-footer>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'app',
  components: {

  },
  data () {
    return {
      comments: [],
    }
  },
  created: function () {
    this.$http
            .post('http://127.0.0.1:8888/onCreate')
            .then(response => {
              window.console.log(response);
              this.comments = response.data.comments[0];
            })
  },
  methods: {
    loadMore: function() {
      this.$http
              .post('http://127.0.0.1:8888/loadMore', this.comments[this.comments.length - 1])
              .then(response => {
                window.console.log(response);
                for (let i = 0; i < response.data.moreComments[0].length; i++) {
                  this.comments.push(response.data.moreComments[0][i]);
                }
              })
    },
    refresh: function () {
      this.$http
              .post('http://127.0.0.1:8888/refresh')
              .then(response => {
                window.console.log(response);
                window.console.log(response.data.comments[0]);
                this.comments = response.data.comments[0];
              })
    },
    convertTime: function (time) {
      let date = new Date(time);
      return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
              + " " + date.getHours() + ":" + date.getMinutes();
    }
  }
}
</script>

<style>
  body {
    margin: 0;
  }

  #app {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    background-image: linear-gradient(-90deg, #ACB6E5 0%, #91EAE4 100%);
  }

  .header {
    margin: 40px 0 50px;
    font-size: 48px;
    color: white;

  }

  .el-container {
    min-height: 100vh;
  }

  .el-footer {
    background-image: linear-gradient(-90deg, #ACB6E5 0%, #91EAE4 100%);
    color: white;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    text-align: center;
    min-height: calc(100vh - 60px);
  }

  .main-card {
    margin: 20px auto;
    max-width: 600px;
    width: 100%;
  }

  .more {
    margin: 50px auto 20px;
  }

  .refresh {
    position: absolute;
    right: 100px;
    top: 100px;
  }

  .box-card-appear-class {
    opacity: 0;
    transform: translateY(20px);
  }

  .box-card-appear-active-class {
    transition: all 1s ease;
  }

  .box-card {
    height: 300px;
    text-align: left;
    margin: 10px;
    background-color: rgba(255, 255, 255, .8) !important;
  }

  .headline {
    display: flex;
    flex-direction: row;
    height: 20px;
    font-size: 15px;
  }

  .user {
    flex-grow: 3;
    margin-right: 10px;
    text-align: left;
  }

  .time {
    flex-grow: 1;
    margin-left: 10px;
    text-align: right;
  }

  .card-content {
    display: flex;
    flex-direction: row;
    height: 203px;
  }

  .text {
    font-size: 14px;
    flex-grow: 1;
    overflow: auto;
  }

  .text::-webkit-scrollbar{
    display:none;
  }

  .image {
    flex-grow: 0;
    flex-shrink: 0;
    width: 35%;
    height: 100%;
    margin-left: 10px;
  }

</style>
