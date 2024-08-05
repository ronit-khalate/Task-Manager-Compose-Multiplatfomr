package task_feature.domain

data class TaskDto(
    val title:String,
    val description:String,
    val dueDate:String,
    val status:Boolean=false
)