import "server-only";

import { Workspace } from "@modules/workspace/api/workspace.types";
import { Box, Stack, Typography } from "@ui/atoms";
import { FC } from "react";

import { Pagination } from "@/basic/types/pagination.types";

const getData = async (): Promise<Pagination<Workspace>> => {
  const res = await fetch(`${process.env.BE_API_URL ?? ""}/workspace`);

  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }

  return (await res.json()) as Pagination<Workspace>;
};

const WorkspaceList: FC = async () => {
  const workspaces = await getData();

  return (
    <Stack>
      <Box>
        {workspaces.content.map((workspace) => (
          <Box key={workspace.id}>
            <Typography>{workspace.name}</Typography>
          </Box>
        ))}
      </Box>
      <Box></Box>
    </Stack>
  );
};

export default WorkspaceList;
