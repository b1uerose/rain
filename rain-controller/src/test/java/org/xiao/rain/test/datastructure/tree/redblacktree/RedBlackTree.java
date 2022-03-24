package org.xiao.rain.test.datastructure.tree.redblacktree;

/**
 * 红黑树
 * Author: xiaojl
 * Date: 2021/12/31 14:03
 */
public class RedBlackTree<T extends Comparable<T>> {

    private RedBlackTreeNode<T> root;

    public void add(T value) {
        if (value == null) {
            throw new NullPointerException();
        }

        RedBlackTreeNode<T> tempNode = this.root;

        if (tempNode == null) {
            tempNode = new RedBlackTreeNode<>(null, null, null, Color.BLACK, value);
            this.root = tempNode;
            return;
        }

        int cmp;
        RedBlackTreeNode<T> parent;

        do {
            parent = tempNode;
            cmp = value.compareTo(parent.getValue());
            if (cmp > 0) {
                tempNode = parent.getRightTreeNode();
            } else if (cmp < 0) {
                tempNode = parent.getLeftTreeNode();
            } else {
                return;
            }
        } while (tempNode != null);

        cmp = value.compareTo(parent.getValue());

        RedBlackTreeNode<T> newNode = new RedBlackTreeNode<>(null, null, parent, Color.RED, value);
        if (cmp > 0) {
            parent.setRightTreeNode(newNode);
        } else {
            parent.setLeftTreeNode(newNode);
        }

        fixAfterInsertion(newNode);
    }

    public void delete(T value) {

        RedBlackTreeNode<T> node = this.root;
        if (node == null) {
            return;
        }

        while (node != null) {
            int cmp = node.getValue().compareTo(value);
            if (cmp > 0) {
                node = node.getLeftTreeNode();
            } else if (cmp < 0) {
                node = node.getRightTreeNode();
            } else {
                break;
            }
        }

        if (node == null) {
            return;
        }

        //有两个节点
        if (node.getLeftTreeNode() != null && node.getRightTreeNode() != null) {
            RedBlackTreeNode<T> replaceNode = successor(node);
            node.setValue(replaceNode.getValue());
            node = replaceNode;
        }

        RedBlackTreeNode<T> replaceNode = node.getLeftTreeNode() != null ? node.getLeftTreeNode() :
                node.getRightTreeNode();

        if (replaceNode != null) {
            replaceNode.setParentTreeNode(node.getParentTreeNode());

            RedBlackTreeNode<T> parent = node.getParentTreeNode();
            if (parent == null) {
                root = replaceNode;
            } else if (node == leftOf(parent)) {
                parent.setLeftTreeNode(replaceNode);
            } else if (node == rightOf(parent)) {
                parent.setRightTreeNode(replaceNode);
            }

            node.setParentTreeNode(null);
            node.setRightTreeNode(null);
            node.setLeftTreeNode(null);
            if (colorOf(node) == Color.BLACK) {
                fixAfterDeletion(replaceNode);
            }
        } else if (node.getParentTreeNode() == null) {
            root = null;
        } else {
            if (colorOf(node) == Color.BLACK) {
                fixAfterDeletion(node);
            }
            RedBlackTreeNode<T> parent = node.getParentTreeNode();
            if (parent != null) {
                node.setParentTreeNode(null);
                if (node == leftOf(parent)) {
                    parent.setLeftTreeNode(null);
                } else {
                    parent.setRightTreeNode(null);
                }
            }
        }
    }

    public void fixAfterInsertion(RedBlackTreeNode<T> node) {
        while (node != null && node != this.root && colorOf(parentOf(node)) == Color.RED) {
            //如果父节点是祖父节点的左子树
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                //父节点的兄弟节点 (当前节点的叔叔节点)
                RedBlackTreeNode<T> uncle = rightOf(parentOf(parentOf(node)));
                RedBlackTreeNode<T> parent = parentOf(node);
                //1、如果叔叔节点是红色的，那么把父节点和叔叔节点染成黑色，爷爷节点染成红色。node指向爷爷节点继续循环
                if (colorOf(uncle) == Color.RED) {
                    //1.1、父节点和叔叔节点染成黑色
                    setColor(parent, Color.BLACK);
                    setColor(uncle, Color.BLACK);
                    RedBlackTreeNode<T> grandFather = parentOf(parent);
                    //1.2、爷爷节点染成红色
                    setColor(grandFather, Color.RED);
                    node = grandFather;
                } else {
                    //2、如果叔叔节点是null 或者是黑色的。
                    //2.1、当前节点是父节点的右子树
                    if (node == rightOf(parent)) {
                        node = parent;
                        //2.1.1 按照父节点左旋转，当前节点指向父节点
                        rotateLeft(node);
                    }
                    //2.2、node的父节点设置为黑色，爷爷节点设置为红色
                    setColor(parentOf(node), Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    //2.3、根据爷爷节点右旋
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                //如果父节点是祖父节点的右子树 ，那么叔叔节点就是在左子树上
                RedBlackTreeNode<T> uncle = leftOf(parentOf(parentOf(node)));
                RedBlackTreeNode<T> parent = parentOf(node);
                //1、如果叔叔节点是红色的，那么把父节点和叔叔节点染成黑色，爷爷节点染成红色。node指向爷爷节点继续循环
                if (colorOf(uncle) == Color.RED) {
                    //1.1、父节点和叔叔节点染成黑色
                    setColor(parent, Color.BLACK);
                    setColor(uncle, Color.BLACK);
                    RedBlackTreeNode<T> grandFather = parentOf(parent);
                    //1.2、爷爷节点染成红色
                    setColor(grandFather, Color.RED);
                    node = grandFather;
                } else {
                    //2、如果叔叔节点是null 或者是黑色的。
                    //2.1、当前节点是父节点的左子树
                    if (node == leftOf(parent)) {
                        node = parent;
                        //2.1.1 按照父节点左旋转，当前节点指向父节点
                        rotateRight(node);
                    }
                    //2.2、node的父节点设置为黑色，爷爷节点设置为红色
                    setColor(parentOf(node), Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    //2.3、根据爷爷节点左旋
                    rotateLeft(parentOf(parentOf(node)));
                }

                //3、根节点需要设置为黑色
            }
        }
        setColor(this.root, Color.BLACK);
    }

    /**
     * 删除后的动作处理
     *
     * @param node
     */
    private void fixAfterDeletion(RedBlackTreeNode<T> node) {
        //删除节点必须是黑色节点，才需要调整红黑树
        while (node != null && node != root && colorOf(node) == Color.BLACK) {
            RedBlackTreeNode<T> parent = parentOf(node);
            //节点是左子节点
            if (node == leftOf(parent)) {
                //兄弟节点
                RedBlackTreeNode<T> brother = rightOf(parent);
                //1、如果兄弟节点是红色节点
                // 1.1、父节点设置为红色
                // 1.2、兄弟节点设置为黑色
                // 1.3、父节点左旋，并重新设置兄弟节点
                if (colorOf(brother) == Color.RED) {
                    setColor(parent, Color.RED);
                    setColor(brother, Color.BLACK);
                    rotateLeft(parent);
                    brother = leftOf(brother);
                }

                if (colorOf(leftOf(brother)) == Color.BLACK && colorOf(rightOf(brother)) == Color.BLACK) {
                    setColor(brother, Color.RED);
                    node = parentOf(node);
                } else {
                    //如果兄弟节点的左子节点是红色
                    if (colorOf(rightOf(brother)) == Color.BLACK) {
                        setColor(leftOf(brother), Color.BLACK);
                        setColor(brother, Color.RED);
                        rotateRight(brother);
                        brother = rightOf(parentOf(node));
                    }

                    setColor(brother, colorOf(parentOf(node)));
                    setColor(parentOf(node), Color.BLACK);
                    setColor(rightOf(brother), Color.BLACK);
                    rotateLeft(parentOf(node));
                    node = root;
                }
            } else {
                RedBlackTreeNode<T> brother = leftOf(parent);
                if (colorOf(brother) == Color.RED) {
                    setColor(parentOf(node), Color.RED);
                    setColor(brother, Color.BLACK);
                    rotateRight(parent);
                    brother = rightOf(brother);
                }

                if (colorOf(rightOf(brother)) == Color.BLACK && colorOf(leftOf(brother)) == Color.BLACK) {
                    setColor(brother, Color.RED);
                    node = parentOf(node);
                } else {
                    //说明兄弟节点的右子树是红色的，那么需要左旋
                    if (colorOf(leftOf(brother)) == Color.BLACK) {
                        setColor(rightOf(brother), Color.BLACK);
                        setColor(parentOf(node), Color.RED);
                        rotateLeft(brother);
                        brother = leftOf(parentOf(node));
                    }

                    setColor(brother, colorOf(parentOf(node)));
                    setColor(parentOf(node), Color.BLACK);
                    setColor(leftOf(brother), Color.BLACK);
                    rotateRight(parentOf(node));
                    node = root;
                }
            }
        }

        setColor(node, Color.BLACK);
    }

    private void setColor(RedBlackTreeNode<T> node, Color color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    private Color colorOf(RedBlackTreeNode<T> node) {
        return node == null ? Color.BLACK : node.getColor();
    }

    public RedBlackTreeNode<T> parentOf(RedBlackTreeNode<T> node) {
        return node == null ? null : node.getParentTreeNode();
    }

    public RedBlackTreeNode<T> leftOf(RedBlackTreeNode<T> node) {
        return node == null ? null : node.getLeftTreeNode();
    }

    public RedBlackTreeNode<T> rightOf(RedBlackTreeNode<T> node) {
        return node == null ? null : node.getRightTreeNode();
    }

    /**
     * 左旋
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<T> rotateLeft(RedBlackTreeNode<T> node) {
        if (node != null) {
            //右子树
            RedBlackTreeNode<T> rightChildTreeNode = node.getRightTreeNode();
            //父级节点
            node.setRightTreeNode(rightChildTreeNode.getLeftTreeNode());
            if (rightChildTreeNode.getLeftTreeNode() != null) {
                rightChildTreeNode.getLeftTreeNode().setParentTreeNode(node);
            }
            rightChildTreeNode.setParentTreeNode(node.getParentTreeNode());

            if (node.getParentTreeNode() == null) {
                this.root = rightChildTreeNode;
            } else if (node.getParentTreeNode().getRightTreeNode() == node) {
                node.getParentTreeNode().setRightTreeNode(rightChildTreeNode);
            } else {
                node.getParentTreeNode().setLeftTreeNode(rightChildTreeNode);
            }
            rightChildTreeNode.setLeftTreeNode(node);
            node.setParentTreeNode(rightChildTreeNode);
            return rightChildTreeNode;
        }
        return null;
    }

    /**
     * 右旋
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<T> rotateRight(RedBlackTreeNode<T> node) {
        if (node != null) {
            RedBlackTreeNode<T> leftChildTreeNode = node.getLeftTreeNode();
            node.setLeftTreeNode(leftChildTreeNode.getRightTreeNode());
            if (leftChildTreeNode.getRightTreeNode() != null) {
                leftChildTreeNode.getRightTreeNode().setParentTreeNode(node);
            }
            if (node.getParentTreeNode() == null) {
                this.root = leftChildTreeNode;
            } else if (node.getParentTreeNode().getRightTreeNode() == node) {
                node.getParentTreeNode().setRightTreeNode(leftChildTreeNode);
            } else {
                node.getParentTreeNode().setLeftTreeNode(leftChildTreeNode);
            }

            leftChildTreeNode.setRightTreeNode(node);
            node.setParentTreeNode(leftChildTreeNode);
            return leftChildTreeNode;
        }
        return null;
    }

    private RedBlackTreeNode<T> getNode(T value) {
        if (value == null) {
            return null;
        }
        RedBlackTreeNode<T> node = this.root;
        while (node != null) {
            int cmp = value.compareTo(node.getValue());
            if (cmp > 0) {
                node = node.getRightTreeNode();
            } else if (cmp < 0) {
                node = node.getLeftTreeNode();
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 后继节点
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<T> successor(RedBlackTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        RedBlackTreeNode<T> successor;
        if (node.getRightTreeNode() != null) {
            successor = node.getRightTreeNode();
            while (successor.getLeftTreeNode() != null) {
                successor = successor.getLeftTreeNode();
            }
        } else {
            successor = node.getParentTreeNode();
            RedBlackTreeNode<T> current = node;
            while (successor != null && successor.getRightTreeNode() == current) {
                current = successor;
                successor = successor.getParentTreeNode();
            }
        }
        return successor;
    }

    /**
     * 前驱节点
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<T> predecessor(RedBlackTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        RedBlackTreeNode<T> predecessor;
        if (node.getLeftTreeNode() != null) {
            predecessor = node.getLeftTreeNode();
            while (predecessor.getRightTreeNode() != null) {
                predecessor = predecessor.getRightTreeNode();
            }
        } else {
            predecessor = node.getParentTreeNode();
            RedBlackTreeNode<T> current = node;
            while (predecessor != null && current == predecessor.getLeftTreeNode()) {
                current = predecessor;
                predecessor = predecessor.getParentTreeNode();
            }
        }
        return predecessor;
    }

}
