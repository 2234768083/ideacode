<template>
  <div>
    <div style="margin: 10px 0">
      <el-carousel height="450px" :interval="10000">
        <el-carousel-item v-for="item in lun" :key="item.id">
          <a :href="item.link" target="_blank"><img :src="item.img" alt="" style="width: 100%"></a>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div style="margin: 10px 0">
      <div style="margin: 20px 0; font-size: 20px; color: orangered; border-bottom: 1px solid orangered; padding-bottom: 10px">商品列表</div>
      <el-row :gutter="10">
        <el-col :span="6" v-for="item in goods" :key="item.id" style="margin-bottom: 10px">
          <div style="background-color: white; padding: 10px; cursor: pointer" @click="$router.push('/front/detail?id=' + item.id)">
            <img :src="item.img" alt="" style="width: 100%; height: 200px; overflow: hidden; border-radius: 10px">
            <div style="color: #666; margin: 10px 0" class="line1">{{ item.name }}</div>
            <div style="margin: 10px 0; color: red; font-weight: bold; font-size: 14px">￥{{ item.price }} / {{ item.unit }}</div>
          </div>
        </el-col>
      </el-row>
      <div style="padding: 10px 0; background-color: white">
        <el-pagination
            background
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[4, 8, 12]"
            :page-size="pageSize"
            layout="total, prev, pager, next"
            :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FrontHome",
  data() {
    return {
      lun: [],
      files: [],
      goods: [],
      pageNum: 1,
      pageSize: 8,
      total: 0
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.request.get("/lun").then(res => {
        this.lun = res.data
      })

      this.request.get("/goods/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
        }
      }).then(res => {
        this.goods = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
  }
}
</script>

<style>
  .line1 {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
</style>
