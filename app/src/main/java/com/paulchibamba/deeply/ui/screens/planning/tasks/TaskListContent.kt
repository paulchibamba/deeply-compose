package com.paulchibamba.deeply.ui.screens.planning.tasks

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulchibamba.deeply.R
import com.paulchibamba.deeply.model.Task
import com.paulchibamba.deeply.model.WorkType
import com.paulchibamba.deeply.model.getCategoryId
import com.paulchibamba.deeply.model.getPriorityColor
import com.paulchibamba.deeply.ui.theme.LARGE_PADDING
import com.paulchibamba.deeply.ui.theme.MEDIUM_PADDING
import com.paulchibamba.deeply.ui.theme.PRIORITY_INDICATOR_SIZE
import com.paulchibamba.deeply.ui.theme.SMALL_PADDING
import com.paulchibamba.deeply.ui.theme.XX_LARGE_PADDING
import com.paulchibamba.deeply.ui.theme.X_LARGE_PADDING
import com.paulchibamba.deeply.utils.toDynamicDuration

@Composable
fun TaskListContent(
    tasks: List<Task>,
    navigateToTaskDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = tasks,
            key = { task -> task.id }
        ) { task ->
            TaskItem(
                task = task,
                navigateToTaskDetail = navigateToTaskDetail,
                modifier = modifier
            )
        }

    }
}

@Composable
fun TaskItem(
    task: Task,
    navigateToTaskDetail: (Long) -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh)
    ) {
        Column(
            modifier = Modifier
                .padding(X_LARGE_PADDING)
                .fillMaxWidth()

        ) {
            Row {
                Text(
                    modifier = Modifier.padding(top = MEDIUM_PADDING),
                    text = task.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
            Text(
                modifier = Modifier.padding(top = SMALL_PADDING),
                text = task.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Surface(
                modifier = Modifier.padding(top = XX_LARGE_PADDING),
                shape = RoundedCornerShape(16.dp),
                onClick = {},
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Row(
                    modifier = Modifier.padding(SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = if (task.category == task.getCategoryId()) R.drawable.ic_neurology_24 else R.drawable.ic_assignment_24),
                        contentDescription = "Task Category Icon",
                        tint = task.getPriorityColor()
                    )
                    Text(
                        modifier = Modifier.padding(start = SMALL_PADDING, end = SMALL_PADDING),
                        text = "${if (task.category == task.getCategoryId()) "Deep Work" else "Shallow Work"} • ${task.estimatedDurationMillis.toDynamicDuration()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        task = Task(
            id = 1,
            title = "iOS Development",
            description = "Complete chapter 4 of the iOS Development book. The topic is View Controllers, nib files, and storyboard files.",
            category = 0,
            priority = 2,
            status = 0,
            estimatedDurationMillis = 2400000,
            actualDurationMillis = 10000,
            scheduledDateMillis = 10000,
            scheduledTimeMillis = 10000,
            completedAtMillis = 10000,
            parentTaskId = 2,
            projectId = 2
        ),
        navigateToTaskDetail = {},
        modifier = Modifier
    )
}