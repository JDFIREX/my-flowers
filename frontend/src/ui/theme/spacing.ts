import { createSpacing, Spacing } from "@mui/system";

export const spacing: Spacing = createSpacing(
  Object.values({
    NONE: "0px",
    XXXX_SMALL: "4px",
    XXX_SMALL: "8px"
  })
);
