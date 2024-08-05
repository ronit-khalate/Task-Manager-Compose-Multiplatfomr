package task_feature.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import task_feature.domain.TaskDto
import task_feature.presentation.components.TaskComposable
import task_feature.presentation.components.TaskListTopBar

@Composable
fun TaskListScreen(modifier: Modifier = Modifier) {

    var showCompletedTasks by remember { mutableStateOf(true) }
    val floatingActionButtonSize = 60.dp
    val listInnerPadding = 24.dp

    Scaffold(
        modifier = modifier
            .safeDrawingPadding()
            .padding(top = listInnerPadding),
        topBar = { TaskListTopBar(
            innerPadding = listInnerPadding
        ) },
        backgroundColor = Color(0xFF27323A),
        floatingActionButton = {

            FloatingActionButton(
                modifier = Modifier
                    .size(floatingActionButtonSize),
                onClick = {TODO("Implement Add Task")},
                shape = CircleShape,
                backgroundColor = Color(0xFF435055)
            ){
                Image(
                    modifier = Modifier
                        .size(35.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task",
                    colorFilter = ColorFilter.tint(color = Color(0xFFA3F7BF))
                )
            }

        }
    ){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = listInnerPadding, end = listInnerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            items(3){

                TaskComposable(
                    task = TaskDto(
                        title = "Do Home Work",
                        description = "Math Home should be done fist \n then chemistry",
                        status = false,
                        dueDate = "10/5/24"
                    )
                )


            }

            item {
                Spacer(Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        text = "Completed",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color.LightGray
                    )

                    IconButton(
                        onClick = {
                            showCompletedTasks = !showCompletedTasks
                        }
                    ) {

                        Image(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = if(showCompletedTasks)Icons.Filled.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            colorFilter = ColorFilter.tint(Color.Gray),
                            contentDescription = null
                        )
                    }
                }
            }


            if(showCompletedTasks) {



                items(5){

                    TaskComposable(
                        task = TaskDto(
                            title = "Do Home Work",
                            description = "Math Home should be done fist \n then chemistry",
                            status = true,
                            dueDate = "10/5/24"
                        )
                    )
                }

                item { Spacer(modifier = Modifier.height(floatingActionButtonSize + 10.dp))}
            }


        }


    }
}