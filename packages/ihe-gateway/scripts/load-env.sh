#!/bin/bash

# Fail on error
set -e

#################################################################################
#
# Load environment variables from a .env file.
# Pass 'strict' as the first argument to fail if no .env file is found.
#
#################################################################################

if [ -f .env ]; then
    set -o allexport
    source .env
    set +o allexport
else
    if [ "$1" == "strict" ]; then
        echo "Error: No .env file found"
        exit 1
    fi
    echo "Warning: No .env file found, expecting env vars to be set"
fi
