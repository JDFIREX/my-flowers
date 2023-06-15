import "server-only";

import { WorkspaceList } from "@modules/workspace/components";
import { Box } from "@ui/atoms";
import { FC } from "react";

const Home: FC = () => {
  return (
    <Box>
      <WorkspaceList />
    </Box>
  );
};

export default Home;
