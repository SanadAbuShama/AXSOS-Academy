import React, { useEffect } from "react";

const Chat = () => {
  useEffect(() => {
    socket.on("Welcome", (msg) => {
      console.log(msg);
    });
  });

  return <div>Chat</div>;
};

export default Chat;
