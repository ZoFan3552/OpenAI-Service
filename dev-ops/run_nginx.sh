 docker run \
--name Nginx \
-p 443:443 -p 80:80 \
-v /home/zeddic/Documents/练手项目/ChatGPT-Project/OpenAI-Project/dev-ops/nginx/logs:/var/log/nginx \
-v /home/zeddic/Documents/练手项目/ChatGPT-Project/OpenAI-Project/dev-ops/nginx/html:/usr/share/nginx/html \
-v /home/zeddic/Documents/练手项目/ChatGPT-Project/OpenAI-Project/dev-ops/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
-v /home/zeddic/Documents/练手项目/ChatGPT-Project/OpenAI-Project/dev-ops/nginx/conf.d:/etc/nginx/conf.d \
-v /home/zeddic/Documents/练手项目/ChatGPT-Project/OpenAI-Project/dev-ops/nginx/ssl:/etc/nginx/ssl/  \
--privileged=true -d --restart=always nginx
