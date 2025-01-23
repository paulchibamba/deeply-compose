package com.paulchibamba.deeply.ui.screens.plan.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulchibamba.deeply.model.Project
import com.paulchibamba.deeply.model.getPriorityColor
import com.paulchibamba.deeply.ui.components.NoContent
import com.paulchibamba.deeply.ui.theme.MEDIUM_PADDING
import com.paulchibamba.deeply.ui.theme.SMALL_PADDING
import com.paulchibamba.deeply.ui.theme.X_LARGE_PADDING
import com.paulchibamba.deeply.utils.RequestState
import com.paulchibamba.deeply.utils.daysUntil

@Composable
fun ProjectListContent(
    projects: RequestState<List<Project>>,
    navigateToProjectDetailScreen: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    if (projects is RequestState.Success) {
        if (projects.data.isEmpty()) {
            NoContent()
        } else {
            ProjectList(
                projects = projects.data,
                navigateToTaskDetail = navigateToProjectDetailScreen,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ProjectList(
    projects: List<Project>,
    navigateToTaskDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = projects,
            key = { project -> project.id }
        ) { project  ->
            ProjectItem(
                project = project,
                navigateToProjectDetail = navigateToTaskDetail,
                modifier = modifier
            )
        }

    }
}

@Composable
fun ProjectItem(
    project: Project,
    navigateToProjectDetail: (Long) -> Unit,
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
                    modifier = Modifier
                        .padding(top = MEDIUM_PADDING)
                        .weight(8f),
                    text = project.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )

            }
            Text(
                modifier = Modifier.padding(top = SMALL_PADDING),
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            LinearProgressWithLabels(
                timeLeft = project.endDateMillis.daysUntil(),
                progress = 0.7f,
                color = project.getPriorityColor()
            )
        }
    }
}

@Composable
fun LinearProgressWithLabels(
    timeLeft: String,
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = X_LARGE_PADDING)
    ) {
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
            color = color,
        )
        Row(
            modifier = Modifier.padding(top = SMALL_PADDING).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .alpha(0.7f),
                text = timeLeft,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview
@Composable
fun ProjectItemPreview() {
    ProjectItem(
        project = Project(
            id = 0,
            name = "Learn iOS Development",
            description = "Learn how to develop iOS apps from scratch",
            priority = 2,
            startDateMillis = 1737540861389,
            endDateMillis = 1741169797438,
            status = 2,
        ),
        navigateToProjectDetail = {},
        modifier = Modifier
    )
}