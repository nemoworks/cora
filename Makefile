ARGS :=
commit_id := $(shell git log -1 --format=%h)

run-drone-local:
	drone exec --trusted \
		--sha ${commit_id} --repo cora \
		--secret-file ci/secrets.local.txt \
		--exclude=git-clone ${ARGS}