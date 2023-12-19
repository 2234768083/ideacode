<template>
  <div>
<!--    <div style="margin: 10px 0">-->
<!--&lt;!&ndash;      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>&ndash;&gt;-->
<!--      <el-popconfirm-->
<!--          class="ml-5"-->
<!--          confirm-button-text='确定'-->
<!--          cancel-button-text='我再想想'-->
<!--          icon="el-icon-info"-->
<!--          icon-color="red"-->
<!--          title="您确定批量删除这些数据吗？"-->
<!--          @confirm="delBatch"-->
<!--      >-->
<!--        <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i></el-button>-->
<!--      </el-popconfirm>-->
<!--    </div>-->

    <el-table :data="tableData" stripe size="medium">
      <el-table-column prop="id" label="ID" width="80" sortable></el-table-column>
      <el-table-column prop="orderno" label="订单编号" width="200"></el-table-column>
      <el-table-column prop="total" label="总金额"></el-table-column>
<!--      <el-table-column prop="userid" label="用户id"></el-table-column>-->
      <el-table-column prop="status" label="状态">
        <template v-slot="scope">
          <el-tag type="info" v-if="scope.row.status === 0">已取消</el-tag>
          <el-tag type="warning" v-if="scope.row.status === 1">待支付</el-tag>
          <el-tag type="primary" v-if="scope.row.status === 2">待发货</el-tag>
          <el-tag type="primary" v-if="scope.row.status === 3">待收货</el-tag>
          <el-tag type="danger" v-if="scope.row.status === 4">待评价</el-tag>
          <el-tag type="success" v-if="scope.row.status === 5">已完成</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
      <el-table-column prop="payTime" label="付款时间"></el-table-column>
      <el-table-column prop="payno" label="付款编号"></el-table-column>
      <el-table-column label="详情">
        <template v-slot="scope">
          <el-button @click="detail(scope.row.id)">查看详情</el-button>
        </template>
      </el-table-column>

      <el-table-column label="操作"  width="180" align="center">
        <template v-slot="scope">
          <el-button type="success" @click="changeStatus(scope.row, 2)" v-if="scope.row.status === 1">付款</el-button>
          <el-button type="warning" @click="changeStatus(scope.row, 4)" v-if="scope.row.status === 3">收货</el-button>
          <el-popconfirm
              v-if="scope.row.status === 1"
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定取消吗？"
              @confirm="changeStatus(scope.row, 0)"
          >
            <el-button type="danger" slot="reference">取消</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0; margin: 10px 0; background: white">
      <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="信息" :visible.sync="dialogFormVisible" width="40%" :close-on-click-modal="false">
      <el-table :data="orderItems" stripe size="small">
        <el-table-column prop="goodsName" label="商品名称"></el-table-column>
        <el-table-column prop="price" label="商品单价"></el-table-column>
        <el-table-column prop="num" label="商品数量"></el-table-column>
        <el-table-column prop="img" label="图片">
          <template v-slot="scope">
            <el-image :src="scope.row.img" style="width: 100px; height: 100px"></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="img" label="评价" v-if="">
          <template v-slot="scope">
            <el-button @click="handleComment(scope.row)" type="primary">评价</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">关 闭</el-button>
      </div>
    </el-dialog>

    <el-dialog title="评价内容" :visible.sync="dialogFormVisible1" width="30%" :close-on-click-modal="false">
      <el-form>
        <el-form-item>
          <el-input v-model="comment" type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="saveComment">保 存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Orders",
  data() {
    return {
      showCommentBtn: false,
      comment: '',
      orderItem: {},
      tableData: [],
      orderItems: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      name: "",
      form: {},
      dialogFormVisible: false,
      dialogFormVisible1: false,
      multipleSelection: [],
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      rules: {
        name: [
          { required: true, message: '请输入名称', trigger: 'blur'}
        ],
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    handleComment(row) {
      this.orderItem = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible1 = true
    },
    saveComment() {
      this.orderItem.comment = this.comment
      this.request.post("/orderItem", this.orderItem).then(res => {
        if (res.code === '200') {
          this.$message.success("评价成功")
          this.dialogFormVisible1 = false
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    changeStatus(row, status) {
      row.status = status
      this.request.post("/orders/status", row).then(res => {
        if (res.code === '200') {
          this.$message.success("操作成功")
          this.load()
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    detail(orderId) {
      let order = this.tableData.find(v => v.id === orderId)
      this.orderItems = order.orderItems
      this.dialogFormVisible = true
      this.showCommentBtn = order.status === 4
    },
    load() {
      this.request.get("/orders/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    save() {
        this.$refs['ruleForm'].validate((valid) => {
          if (valid) {
            this.request.post("/orders", this.form).then(res => {
              if (res.code === '200') {
                this.$message.success("保存成功")
                this.dialogFormVisible = false
                this.load()
              } else {
                this.$message.error(res.msg)
              }
            })
          }
        })
    },
    handleAdd() {
      this.dialogFormVisible = true
      this.form = {}
      this.$nextTick(() => {
        if(this.$refs.img) {
           this.$refs.img.clearFiles();
         }
         if(this.$refs.file) {
          this.$refs.file.clearFiles();
         }
      })
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible = true
       this.$nextTick(() => {
         if(this.$refs.img) {
           this.$refs.img.clearFiles();
         }
         if(this.$refs.file) {
          this.$refs.file.clearFiles();
         }
       })
    },
    del(id) {
      this.request.delete("/orders/" + id).then(res => {
        if (res.code === '200') {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val
    },
    delBatch() {
      if (!this.multipleSelection.length) {
        this.$message.error("请选择需要删除的数据")
        return
      }
      let ids = this.multipleSelection.map(v => v.id)  // [{}, {}, {}] => [1,2,3]
      this.request.post("/orders/del/batch", ids).then(res => {
        if (res.code === '200') {
          this.$message.success("批量删除成功")
          this.load()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    reset() {
      this.name = ""
      this.load()
    },
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    },
    handleFileUploadSuccess(res) {
      this.form.file = res
    },
    handleImgUploadSuccess(res) {
      this.form.img = res
    },
    download(url) {
      window.open(url)
    },
    exp() {
      window.open("http://localhost:9090/orders/export")
    },
    handleExcelImportSuccess() {
      this.$message.success("导入成功")
      this.load()
    }
  }
}
</script>


<style>
.headerBg {
  background: #eee!important;
}
</style>
