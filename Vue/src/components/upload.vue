<template>
  <div>
    <el-upload ref="pictureUpload"  action="#" list-type="picture-card" :limit=6 :auto-upload="false">
      <i slot="default" class="el-icon-plus"></i>
      <div slot="file" slot-scope="{ file }">
        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
        <span class="el-upload-list__item-actions">
          <span
            class="el-upload-list__item-preview"
            @click="handlePictureCardPreview(file)">
            <i class="el-icon-zoom-in"></i>
          </span>

          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleRemove(file)">
            <i class="el-icon-delete"></i>
          </span>
        </span>
      </div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="" />
    </el-dialog>
  </div>
</template>

<script>
export default {

  name:'UploadCom',

  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      disabled: false,
    };
  },
  methods: {
    handleRemove(file) {
      let uploadFiles = this.$refs.pictureUpload.uploadFiles
        for (var i = 0; i < uploadFiles.length; i++) {
          if (uploadFiles[i]['url'] == file.url) {
            uploadFiles.splice(i, 1)
          }
        }
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
  },
};
</script>
