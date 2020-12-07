# Babashka Env Repro

This repo was extracted from a project, but usage itself is minimal.

Run `bin/script run.clj` 

You'll see following error 

```clj
warnings can be silenced by the --no-warnings (-n) option
Assertion failed: (str1!= NULL), function add3strings, file string_utils.c, line 103.
```

If you comment out `:env` variable passed to `babashka.process/process` fn in j`scripts/run.clj`, command works.


