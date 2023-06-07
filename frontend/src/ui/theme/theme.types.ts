/* eslint-disable */
declare module "@mui/material/styles" {
  interface Theme {
    //radius: Spacing
  }
  interface ThemeOptions {
    //radius?: SpacingOptions
  }

  interface Palette {
    //tertiary: PaletteColor
  }

  interface PaletteOptions {
    //tertiary?: PaletteColorOptions
  }

  interface TypographyVariants {
    //chip: React.CSSProperties
  }

  interface TypographyVariantsOptions {
    //chip?: React.CSSProperties
  }
}

declare module "@mui/material/Typography" {
  interface TypographyPropsVariantOverrides {
    //chip: true
  }

  interface TypographyClasses {
    //chip: string
  }
}
