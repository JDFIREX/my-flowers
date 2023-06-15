/** @type {import('next').NextConfig} */
const nextConfig = {
  distDir: "dist",
  reactStrictMode: true,
  experimental: {
    serverActions: true
  },
  transpilePackages: []
};

module.exports = nextConfig;
