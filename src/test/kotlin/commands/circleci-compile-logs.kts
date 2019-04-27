#!/usr/bin/env okscript

import com.baulsupp.okurl.kotlin.client
import com.baulsupp.okurl.kotlin.queryList
import kotlinx.coroutines.runBlocking

data class Build(
  val timedout: Boolean,
  val subject: String?,
  val vcsUrl: String?,
  val body: String?,
  val branch: String,
  val oss: Boolean,
  val canceler: Any?,
  val lifecycle: String,
  val allCommitDetails: List<AllCommitDetailsItem>?,
  val authorDate: String?,
  val authorEmail: String?,
  val buildUrl: String?,
  val picard: Any?,
  val allCommitDetailsTruncated: Boolean?,
  val queuedAt: String?,
  val buildTimeMillis: Int?,
  val circleYml: CircleYml?,
  val isFirstGreenBuild: Boolean?,
  val previousSuccessfulBuild: Any?,
  val failed: Boolean,
  val buildParameters: BuildParameters?,
  val infrastructureFail: Boolean?,
  val committerName: String?,
  val retries: Any?,
  val startTime: String?,
  val node: Any?,
  val canceled: Boolean,
  val buildNum: Int?,
  val noDependencyCache: Boolean?,
  val sshDisabled: Boolean?,
  val failReason: Any?,
  val usageQueuedAt: String?,
  val vcsRevision: String?,
  val status: String,
  val authorName: String?,
  val compare: Any?,
  val retryOf: Any?,
  val stopTime: String?,
  val why: String,
  val committerDate: String?,
  val workflows: Workflows,
  val platform: String,
  val vcsTag: Any?,
  val parallel: Int,
  val outcome: String,
  val committerEmail: String?,
  val previous: Previous?,
  val dontBuild: Any?,
  val vcsType: String?,
  val reponame: String,
  val jobName: Any?,
  val hasArtifacts: Boolean?,
  val user: User,
  val username: String
)

data class AllCommitDetailsItem(
  val authorName: String,
  val authorLogin: String,
  val committerEmail: String,
  val subject: String?,
  val commit: String,
  val committerDate: String,
  val body: String?,
  val branch: String,
  val committerName: String,
  val commitUrl: String,
  val committerLogin: String,
  val authorDate: String,
  val authorEmail: String
)

data class CircleYml(val string: String)

data class User(
  val vcsType: String?,
  val avatarUrl: String?,
  val name: String?,
  val id: Int?,
  val login: String,
  val isUser: Boolean?
)

data class BuildParameters(val circleJob: String)

data class Workflows(
  val workspaceId: String?,
  val workflowId: String?,
  val jobName: String?,
  val workflowName: String?,
  val jobId: String?,
  val upstreamConcurrencyMap: Any?
)

data class Previous(
  val buildNum: Int?,
  val buildTimeMillis: Long?,
  val status: String?
)

runBlocking {
  val builds = client.queryList<Build>("https://circleci.com/api/v1.1/recent-builds")
  builds.forEach {
    println(it.reponame + " " + it.buildUrl)
  }
}
