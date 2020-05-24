<template>
  <div>
    <div v-if="!repoUrl">loading</div>
    <div v-else>most star repo is <a :href="repoUrl">{{repoName}}</a></div>
  </div>
</template>

<script>
  export default {
    name: "VueResource",
    data() {
      return {
        repoUrl: '',
        repoName: ''
      }
    },

    mounted() {
      //发ajax请求获取数据
      const url = 'https://api.github.com/search/repositories?q=v&sort=stars';
      this.$http.get(url).then(
        response=>{
          //成功了，返回数据
          const  result = response.data;
          //得到第一个repository
          const mostRepo = result.items[0];
          this.repoUrl = mostRepo.html_url;
          this.repoName = mostRepo.name;
        },
        reponse => {
          alert("请求失败");
        }
      )
    }
  }
</script>

<style scoped>

</style>
